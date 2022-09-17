package zuoye;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal dog=new Dog();  //向上转型定义对象
		dog.YaoWeiBa();              //调用方法
		dog.Eat();                  //调用方法
		Animal cat=new Cat();    //向上转型定义对象
		cat.YaoWeiBa();            //调用方法
		cat.Eat();

	}

}
