package effective.chapter4.item22.constantinterface;

// 코드 22-1 상수 인터페이스 안티패턴 - 사용금지! (139쪽)
//public interface PhysicalConstants {
//    static final double AVOGADROS_NUMBER   = 6.022_140_857e23; // 아보가드로 수 (1/몰)
//    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23; // 볼츠만 상수 (J/K)
//    static final double ELECTRON_MASS      = 9.109_383_56e-31; // 전자 질량 (kg)
//}

public class PhysicalConstants {
    private PhysicalConstants() { }
    public static final double AVOGADROS_NUMBER   = 6.022_140_857e23; // 아보가드로 수 (1/몰)
    public static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23; // 볼츠만 상수 (J/K)
    public static final double ELECTRON_MASS      = 9.109_383_56e-31; // 전자 질량 (kg)
}