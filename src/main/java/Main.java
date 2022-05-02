import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 회원 가입
            Member member = new Member();
            member.setName("ttasjwi");
            em.persist(member);
            System.out.println(member);

            // 아이템 등록
            Item item = new Item();
            item.setName("item");
            item.setPrice(10000);
            item.setStockQuantity(100);
            em.persist(item);
            System.out.println(item);

            // 주문 상품 생성
            OrderItem orderItem = new OrderItem(item, 5);
            em.persist(orderItem);
            System.out.println(orderItem);

            // 주문 생성
            Order order = new Order();
            order.setMember(member);
            order.setOrderStatus(OrderStatus.ORDER);
            order.setOrderDate(LocalDateTime.now());
            order.addOrderItem(orderItem);
            em.persist(order);
            System.out.println(order);

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
