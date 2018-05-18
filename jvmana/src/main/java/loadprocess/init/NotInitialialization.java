package loadprocess.init;


/****
 * 以下3种情况都不会触发类的初始化阶段
 * 在类的加载过程中，不会立即触发初始化阶段
 */
public class NotInitialialization {


    /****
     * 被动引用一:引用父类初始化
     * 通过子类引用父类，只会触发父类的初始化阶段，而不会触发子类的初始化阶段
     * 输出结果为
     * Super class Init
     * 3
      */
//    public static void main(String[] args) {
//        System.out.println(SubClass.value);
//    }


    /****
     * 被动引用二：数组初始化
     * 被动引用案例  数组案例
     * 并不会触发SuperClass的初始化阶段
     * 实际为 new Array
     * @param args
     */
//    public static void main(String[] args) {
//        SuperClass[] sca = new SuperClass[10];
//    }



    /****
     * 被动引用三：静态常量跨类引用
     * 在编译成class阶段，就已经将ConstClass的变量传递给NotInitialialization类的常量池中
     * 在编译完成后，其实已经和ConstClass没有任何关系了。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
