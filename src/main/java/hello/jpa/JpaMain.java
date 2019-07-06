package hello.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
