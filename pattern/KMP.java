package pattern;

public class KMP {
    // pattern의 substring을 이용해서 pattern 찾기
    // 접두사와 접미사 개념을 활용 - 반복되는 연산을 최대한 줄인다
    KMP(String origin, String pattern) {
        int[] pi = getPi(pattern);
        int j = 0;
        for(int i = 0; i < origin.length(); i++) {
            while(0 < j && origin.charAt(i) != pattern.charAt(j)) j = pi[j-1];
            if(origin.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length() - 1) {
                    System.out.println(i - pattern.length() + 1);
                    j = pi[j];
                }
                else j++;
            } else {
                while(0 < j && origin.charAt(i) != pattern.charAt(j)) j = pi[j-1];
            }
        }
    }
    
    static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {
            // correct
            if(pattern.charAt(i) == pattern.charAt(j)) {
                // i길이 문자열의 공통길이는 j의 위치 + i
                pi[i] = ++j;
            } else {
            // incorrect
            // 일치할 때까지 하나 전칸에서의 공통부분 위치로 이동
            while(j < 0 && pattern.charAt(i) != pattern.charAt(j)) j = pi[j-1];
            }
        }
        return pi;
    }
    public static void main(String[] args) {
        String origin = "HELLOSSAFY";
        String pattern = "LOSSA";
        KMP kmp = new KMP(origin, pattern);
    }
}