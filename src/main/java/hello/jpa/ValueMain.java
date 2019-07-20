package hello.jpa;

/**
 * @author hrjin
 * @version 1.0
 * @since 2019-07-20
 */
public class ValueMain {
    public static void main(String[] args){
        int a = 10;
        int b = 10;

        System.out.println("a == b :: " + (a == b)); // true

        Address address1 = new Address("seoul", "hi-ro", "1000");
        Address address2 = new Address("seoul", "hi-ro", "1000");

        System.out.println("address1 == address2 :: " + (address1 == address2)); // false

        // equals 의 기본 비교는 '==' 이므로 equals, hashCode 오버라이드가 필요한데 @Data 에는 @EqualsAndHashCode 포함.
        System.out.println("address1 equals address2 :: " + address1.equals(address2)); // true

    }
}
