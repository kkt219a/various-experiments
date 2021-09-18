package effective.chapter2.item8.autocloseable;

/**
 * 결과:
 * called doIt()
 * called close()
 * called doIt()
 * called close()
 */
public class AutoSample {
    public static void main(String[] args) throws Exception {
        // try-with-resources
        try(AutoCloseableSample autoCloseableSample = new AutoCloseableSample()){
            autoCloseableSample.doIt();
        }
        // 자바 7 이하
        AutoSample autoSample = new AutoSample();
        autoSample.doIt();
    }

    private void doIt() throws Exception {
        AutoCloseableSample autoCloseableSample = null;
        try {
            autoCloseableSample = new AutoCloseableSample();
            autoCloseableSample.doIt();
        }finally {
            if(autoCloseableSample!=null) {
                // try-with-resources를 사용하지 않으면 닫아줘야한다.
                autoCloseableSample.close();
            }
        }
    }
}
