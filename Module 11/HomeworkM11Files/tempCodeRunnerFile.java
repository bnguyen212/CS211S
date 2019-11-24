System.out.print("Q1: Should print 20: ");
		long caCustomters = customerList.stream().filter(cus -> cus.getState() == "CA").count();
		System.out.println(caCustomters);