package array;

/**
 * @author litblue
 * @version 1.0.0
 * @time 2020/9/21  13:28
 *
 * 数组的 CURD 操作
 * 数据类型以 int  为例
 *
 */
public class Array {

    /** 定义整型数据data保存数据*/
    private int[] data;
    /** 数组长度  */
    private int length;
    /** 当前数组实际的个数  */
    private int count;

    /**
     * 构造方法
     *
     * @param capacity 定义列表实际大小
     * @throws IllegalAccessException 初始化容量异常
     */
    private Array(int capacity) throws IllegalAccessException {
        if (capacity >= 0){
            this.data = new int[capacity];
        } else {
            throw new IllegalAccessException("Illegal Capacity: "+ capacity);
        }
        this.length = capacity;
        this.count = 0;
    }

    /**
     * 尾部插入, 存储空间满了 自动扩容
     * @param n 待插入的值
     */
    public void insert(int n){
        // 数组已满
        if (count == length){
            // 扩容为原来的1.5倍
            length *= 1.5;
            int [] newData = new int[length];

//            for (int i = 0; i < data.length; i++) {
//                newData[i] = data[i];
//            }

            System.arraycopy(data, 0, newData, 0, data.length);
            this.data = new int[length];
            this.data = newData;
        }
        data[count++] = n;
    }

    /**
     * 根据下标删除(不要求内部有序)
     * @param index 下标
     * @throws IllegalAccessException 下标异常
     */
    public void deleteByIndex(int index) throws IllegalAccessException {
        // 下标不存在
        if (index<0 || index>= count){
            throw new IllegalAccessException("Illegal index:" + index);
        } else {
            data[index] = data[--count];
        }
    }

    /**
     * 根据值删除
     * @param value 待删除的值
     * @return 是否成功
     */
    public boolean deleteByValue(int value){
       // 定义与value相同的值的个数
        int sum = 0;

        for (int i=0; i<count; i++) {
            if (data[i] == value){
                data[i] = data[--count];
                sum++;
            }
        }
        // 没有则返回false
        return sum != 0;
    }

    /**
     * 更新指定下标的值
     * @param index 下标
     * @param value 值
     * @throws IllegalAccessException 下标异常
     */
    public void update(int index, int value) throws IllegalAccessException {
        if (index<0 || index>= count){
            throw new IllegalAccessException("Illegal index:" + index);
        } else {
            data[index] = value;
        }
    }

    /**
     * 根据下标 查找值
     * @param index 下标
     * @return 值
     * @throws IllegalAccessException 下标异常
     */
    public int getValue(int index) throws IllegalAccessException {
        if (index<0 || index >= count){
            throw new IllegalAccessException("Illegal index:" + index);
        } else {
            return data[index];
        }
    }


    /**
     * 打印
     */
    public void print(){
        int i =0;
        System.out.println("数组长度为 ====> " + length);
        System.out.println("实际个数为 ====> " + count);
        for (; i<count; i++) {
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }


    /**
     * 主函数  测试
     * @param args 参数
     * @throws IllegalAccessException 异常
     */
    public static void main(String[] args) throws IllegalAccessException {
        Array array =  new Array(8);

        // 1. 增
        array.insert(1);
        array.insert(3);
        array.insert(7);
        array.insert(12);

        // 2.删
        array.deleteByIndex(1);
        System.out.println(array.deleteByValue(7));

        // 3. 改
        array.update(0,23);

        // 4. 查
        System.out.println(array.getValue(0));

        array.print();

    }


}
