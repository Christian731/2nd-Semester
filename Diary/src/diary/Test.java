package diary;

/**
 *
 * @author cstuser
 */
public class Test {

    public static void main(String[] args) {
        DiaryBook db = new DiaryBook();
        
        db.addDiary(new Diary("Monday", "sunny", "sun"));
        System.out.println(db.toString());
    }

}
