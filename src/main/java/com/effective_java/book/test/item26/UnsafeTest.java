package com.effective_java.book.test.item26;

import java.util.ArrayList;
import java.util.List;

public class UnsafeTest {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

//        unsafeAdd(strings, Integer.valueOf(42));

        String s = strings.get(0);
    }

    // classCastException
//    private static void unsafeAdd(List list, Object o) {
//        list.add(o);
//    }

    // 컴파일 실패, cannot be converted to List<Object>
//    private static void unsafeAdd(List<Object> list, Object o) {
//        list.add(o);
//    }

}
