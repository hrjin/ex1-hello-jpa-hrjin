package hello.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
              // 생성
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("khmin");
//            em.persist(member);

              // 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println(findMember.getId());
//            System.out.println(findMember.getName());

              // 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

              // 수정
//            Member findMember = em.find(Member.class, 2L);
//            findMember.setName("kyunghoon");

            // JPQL
//            List<Member> findMembers = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(5)
//                    .getResultList();
//
//            for(Member member : findMembers) {
//                System.out.println("member ::: " + member.getName());
//            }
/*
            // 비영속 상태
            Member member = new Member();
            member.setId(4L);
            member.setName("allNew");

            // 영속 상태
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");
            // 준영속 상태 : em.detach(member);
            // 객체 삭제 상태 : em.remove(member);

            Member findMember = em.find(Member.class, 4L);
            System.out.println("1차 캐시에서 찾는다...");
            System.out.println("findMember name ::: " + findMember.getName());

*/
/*

            // Example 1 :: 연관관계
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("hrjin");
            //member.setTeam(team);
            em.persist(member);

            // 연관관계 편의 메소드 설정
            team.addMember(member);// 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정하자.

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for(Member m : members) {
                System.out.println("m = " + m.getUsername());
            }

            // Example 2 :: 상속
            Movie movie = new Movie();
            movie.setDirector("A");
            movie.setActor("B");
            movie.setName("토이스토리");
            movie.setPrice(10000);
            em.persist(movie);
*/
/*

            // Example 3 :: MappedSuperClass
            Member member = new Member();
            member.setUsername("user1");
            member.setCreatedBy("hrjin");
            member.setCreatedDate(LocalDateTime.now());

            em.persist(member);

            em.flush();
            em.clear();
*/
/*

            // Example 4 :: 프록시 & Example 5 :: 즉시 로딩과 지연 로딩
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("user1");
            member.setCreatedBy("hrjin");
            member.setCreatedDate(LocalDateTime.now());
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            //Member findMember = em.getReference(Member.class, member.getId());
            //System.out.println("findMember.username = " + findMember.getUsername());

*/
/*

            // 지연 로딩 사용해서 프록시로 조회
            Member m  = em.find(Member.class, member.getId());

            System.out.println("m = " + m.getTeam().getClass()); // proxy 객체 출력

            // 실제 Team 을 사용하는 시점에 프록시 초기화(DB 조회)
            System.out.println("========================");
            m.getTeam().getName(); // 이 순간 초기화
            System.out.println("========================");
*//*


            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();

            for(Member member1 : members){
                System.out.println("member ::: " + member1.getTeam().getName());
            }
*/

            // Example 6 :: 영속성 전이와 고아 객체
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
            //em.persist(child1);
            //em.persist(child2);

            em.flush();
            em.clear();

            // 고아 객체
            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);

            // 실제 DB에 저장
            tx.commit();

        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();







    }
}
