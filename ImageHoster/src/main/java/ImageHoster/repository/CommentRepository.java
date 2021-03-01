package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;



    public Comment addComment(Comment comment)
    {
        EntityManager em=emf.createEntityManager();
        EntityTransaction transaction=em.getTransaction();
        try
        {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return comment;
    }


//    //The method creates an instance of EntityManager
//    //Executes JPQL query to fetch all the images from the database
//    //Returns the list of all the images fetched from the database
//    public List<Image> getAllImages() {
//        EntityManager em = emf.createEntityManager();
//        TypedQuery<Image> query = em.createQuery("SELECT i from Image i", Image.class);
//        List<Image> resultList = query.getResultList();
//
//        return resultList;
//    }


}
