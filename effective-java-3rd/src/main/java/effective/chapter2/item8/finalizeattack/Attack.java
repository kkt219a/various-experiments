package effective.chapter2.item8.finalizeattack;

public class Attack extends SuperAttack{
    static SuperAttack superAttack;
    public Attack(Integer value) {
        super(value);
    }
    public void finalize(){
        superAttack = this;
    }
    public static void main(String[] args) throws InterruptedException {
        SuperAttack attack =null;
        System.out.println("superAttack = " + superAttack);
        try{
            attack = new Attack(-1);
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        System.gc();
        System.runFinalization();
        Thread.sleep(2000L);
        System.out.println("superAttack = " + superAttack);
        System.out.println("attack = " + attack);
    }
}
