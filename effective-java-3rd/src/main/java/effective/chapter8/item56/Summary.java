package effective.chapter8.item56;

public class Summary {
    // 문서화 주석 첫 '문장'에 마침표가 있을 때 요약 설명 처리 (337쪽)
    /**
     * A suspect, such as Colonel Mustard or {@literal Mrs. Peacock}.
     */
//    public enum Suspect {
//        MISS_SCARLETT, PROFESSOR_PLUM, MRS_PEACOCK, MR_GREEN, COLONEL_MUSTARD, MRS_WHITE
//    }

    // 한글 버전 (337쪽)
    // /**
    //  * 머스타드 대령이나 {@literal Mrs. 피콕} 같은 용의자.
    //  */
    // public enum Suspect {
    //     MISS_SCARLETT, PROFESSOR_PLUM, MRS_PEACOCK, MR_GREEN, COLONEL_MUSTARD, MRS_WHITE
    // }

    /**
     * {@summary A suspect, such as Colonel Mustard or Mrs. Peacock.}
     */
    public enum Suspect {
        MISS_SCARLETT, PROFESSOR_PLUM, MRS_PEACOCK, MR_GREEN, COLONEL_MUSTARD, MRS_WHITE
    }
}
