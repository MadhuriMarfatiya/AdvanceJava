package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class UserTest {

	public static void main(String[] args) throws Exception {
		add();
		// update();
		// delete();
		// findById();
		// search();

	}

	private static void search() throws Exception {
		UserBean bean1 = new UserBean();
		bean1.setFirstName("a");
		bean1.setLastName("s");

		UserModel m = new UserModel();
		List list = m.search(bean1);// for dynamic search by name and physics marks
		// List list=m.search(null);// for all output of data's in table
		Iterator it = list.iterator();
		while (it.hasNext()) {

			UserBean bean = (UserBean) it.next();
			System.out.print(bean.getId() + "\t");
			System.out.print(bean.getFirstName() + "\t");
			System.out.print(bean.getLastName() + "\t");
			System.out.print(bean.getLoginId() + "\t");
			System.out.println(bean.getPassword() + "\t");
		}

	}

	private static void findById() throws Exception {

		UserModel m = new UserModel();

		UserBean bean = m.findById(2);
		if (bean != null) {
			System.out.print(bean.getId() + "\t");
			System.out.print(bean.getFirstName() + "\t");
			System.out.print(bean.getLastName() + "\t");
			System.out.print(bean.getLoginId() + "\t");
			System.out.println(bean.getPassword() + "\t");
		} else {
			System.out.println("invalid id");
		}

	}

	private static void delete() throws Exception {

		UserBean bean = new UserBean();

		UserModel m = new UserModel();
		m.delete(3);

	}

	private static void update() throws Exception {
		UserBean bean = new UserBean();
		bean.setFirstName("karan");
		bean.setLastName("malvi");
		bean.setLoginId("karanMalvi");
		bean.setPassword("karan@1234");
		bean.setId(3);

		UserModel m = new UserModel();
		m.update(bean);

	}

	private static void add() throws Exception {

		UserBean bean = new UserBean();
		bean.setFirstName("abc");
		bean.setLastName("marfatiya");
		bean.setLoginId("abc@gmail.com");
		bean.setPassword("1234");

		UserModel m = new UserModel();
		m.add(bean);

	}

}
