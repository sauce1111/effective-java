package com.effective_java.book.test.item10;

import java.util.Comparator;

public class PhoneNumber implements Cloneable {

    private static final Comparator<PhoneNumber> COMPARATOR =
        Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
        .thenComparingInt(pn -> pn.prefix)
        .thenComparingInt(pn -> pn.lineNum);

    private final short areaCode, prefix, lineNum;
    private int hashCode;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalStateException(arg + ": " + val);
        }

        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof PhoneNumber)) {
            return false;
        }

        PhoneNumber phoneNumber = (PhoneNumber) o;

        return phoneNumber.lineNum == lineNum && phoneNumber.prefix == prefix && phoneNumber.areaCode == areaCode;
    }

    // 성능이 떨어지는 hashCode()
//    @Override
//    public int hashCode() {
//        return Objects.hash(lineNum, prefix, areaCode);
//    }

    @Override
    public int hashCode() {
        int result = hashCode;

        if (result == 0){
            result = Short.hashCode(areaCode);
            result = 31 * Short.hashCode(prefix);
            result = 31 * Short.hashCode(lineNum);

            hashCode = result;
        }

        return result;
    }

    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // 가장 중요한 필드 areaCode 부터 비교하면서 같지 않을 필드를 찾을 때 까지.
    public int compareTo(PhoneNumber phoneNumber) {
        // 정적 비교자 생성 메소드로 리팩토링
        return COMPARATOR.compare(this, phoneNumber);
    }

}
