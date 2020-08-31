package com.tplink.zhangerchi.javaAssignment.ex2_1;

import org.springframework.lang.Nullable;

import java.util.Date;

/**
 * @author KusaUsagi
 * @description
 * @date 2020/8/27
 */
public class Id {

        private int typeId;
        private String nextNumber;
        private String prefix;
        private String postfix;
        private boolean includeYear;
        private int yearLength;
        private boolean includeMonth;
        private int numberLength;

        public Id(int typeId, @Nullable int yearLength) {
            this.typeId = typeId;
            this.nextNumber = nextNumber;
            this.prefix = prefix;
            this.postfix = postfix;
            this.includeYear = includeYear;
            this.yearLength = yearLength;
            this.includeMonth = includeMonth;
            this.numberLength = numberLength;
        }

        public String getNextNumber(){

            synchronized (Id.class) {
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(prefix);

                if (includeYear) {

                    Date date = new Date();
                    String str = String.valueOf(date.getYear());

                    if (yearLength == 2) {

                        str = str.substring(str.length() - 2);

                    } else if (yearLength == 4) {

                        str = str.substring(str.length() - 4);
                    }

                    stringBuilder.append(str);
                }

                if (includeMonth) {

                    Date date = new Date();
                    int i;
                    if ((i = date.getMonth() + 1) < 10) {
                        stringBuilder.append(0);
                    }

                    stringBuilder.append(String.valueOf(i));
                }

                if (nextNumber.length() < numberLength) {

                    int i = numberLength - nextNumber.length();

                    for (int j = 0; j < i; j++) {
                        stringBuilder.append('0');
                    }
                }
                stringBuilder.append(nextNumber);

                stringBuilder.append(postfix);


                return stringBuilder.toString();
            }
        }


}
