import javafx.scene.shape.Line;
@FunctionalInterface
public interface LineInfoDisplayer {

    String getInfo(Line line);

    public static enum InfoType {
        DISTANCE, MIDPOINT, VERTHORZ, SLOPE;
    }

    public static LineInfoDisplayer createLineInfoDisplayer(InfoType type) {
    	switch (type) {
			case DISTANCE:
				return (Line line) -> {
					double x1 = line.getStartX();
					double x2 = line.getEndX();
					double y1 = line.getStartY();
					double y2 = line.getEndY();
					double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
					return String.format("%.3f", distance);
				};
			case MIDPOINT:
				return (Line line) -> {
					double x1 = line.getStartX();
					double x2 = line.getEndX();
					double y1 = line.getStartY();
					double y2 = line.getEndY();
					double xMid = (x1 + x2) / 2;
					double yMid = (y1 + y2) / 2;
					return String.format("(%s,%s)", Double.toString(xMid), Double.toString(yMid));
				};
			case VERTHORZ:
				return (Line line) -> {
					double x1 = line.getStartX();
					double x2 = line.getEndX();
					double y1 = line.getStartY();
					double y2 = line.getEndY();
					return String.format("Horizontal? %s Vertical? %s", y1==y2, x1 == x2);
				};
			case SLOPE:
				return (Line line) -> {
					double x1 = line.getStartX();
					double x2 = line.getEndX();
					double y1 = line.getStartY();
					double y2 = line.getEndY();
					return String.format("%.3f", -(y2-y1)/(x2-x1));
				};
			default:
		        return null;
    	}

    }

}
