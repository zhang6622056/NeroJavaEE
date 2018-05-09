package fanxing.question;

/**
 * pricties N/2
 * make different params division 2
 * make a table to count the time to division
 * @AUTHOR NERO
 * @date 20180301
 *
 */
public class Division2<T> {

    private T obj;

    private static final int DIVISION = 2;

    private static final int INIT_ARRAY_SIZE = 50;

    private static final float EXPAND_PROPORTION = 0.8f;

    private int ARRAY_SIZE;

    private int EXPAND_SIZE;

    private int SIZE = 0;

    private transient Object[] objarr;

    public Division2(){
        init();
    }


    private void init(){
        if(null == objarr){
            ARRAY_SIZE = INIT_ARRAY_SIZE;
            this.objarr = new Object[ARRAY_SIZE];
            EXPAND_SIZE = (int) (INIT_ARRAY_SIZE * EXPAND_PROPORTION);
        }
    }


    public Division2 add(T t){
        objarr[SIZE] = t;
        SIZE++;

        if(SIZE >= EXPAND_SIZE){
            expand();
        }
        return this;
    }



    private synchronized void expand() {
        ARRAY_SIZE = ARRAY_SIZE * 2;
        EXPAND_SIZE = (int) (ARRAY_SIZE * EXPAND_PROPORTION);
        Object[] temp = new Object[ARRAY_SIZE];

        for(int i = 0 ; i < objarr.length ; i++) {
            temp[i] = objarr[i];
        }

        objarr = temp;
    }


    public DivisionResult[] division(){
        if(null == objarr || objarr.length == 0){
            return null;
        }

        DivisionResult[] re = new DivisionResult[SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            re[i] = doSingleDivision(objarr[i]);
        }

        return re;
    }





    public DivisionResult doSingleDivision(Object cur){
        Long start = null,end = null,count = null;
        String type = "";
        Object result = null;

        if(cur instanceof Double){
            Double a = (Double) cur;
            type = "double";
            start = System.nanoTime();
            result = a / 2;
            end = System.nanoTime();
        }else if(cur instanceof Long){
            Long a = (Long) cur;
            type = "long";
            start = System.nanoTime();
            result = a / 2;
            end = System.nanoTime();
        }else if(cur instanceof Integer){
            Integer a = (Integer) cur;
            type = "integer";
            start = System.nanoTime();
            result = a / 2;
            end = System.nanoTime();
        }else if(cur instanceof Float){
            Float a = (Float) cur;
            type = "float";
            start = System.nanoTime();
            result = a / 2;
            end = System.nanoTime();
        }else{
            return null;
        }

        return new DivisionResult(start,end,end-start,type,result);
    }



    public static class DivisionResult{
        private Long startMills;
        private Long endMills;
        private Long countMills;
        private String type;
        private Object result;


        public Long getStartMills() {
            return startMills;
        }

        public void setStartMills(Long startMills) {
            this.startMills = startMills;
        }

        public Long getEndMills() {
            return endMills;
        }

        public void setEndMills(Long endMills) {
            this.endMills = endMills;
        }

        public Long getCountMills() {
            return countMills;
        }

        public void setCountMills(Long countMills) {
            this.countMills = countMills;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }

        public int toSec(){
            return (int) (countMills * 0.001);
        }

        public DivisionResult(Long startMills, Long endMills, Long countMills, String type, Object result) {
            this.startMills = startMills;
            this.endMills = endMills;
            this.countMills = countMills;
            this.type = type;
            this.result = result;
        }
    }








}
