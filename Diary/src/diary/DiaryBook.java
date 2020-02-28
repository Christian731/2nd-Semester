package diary;

import java.util.Arrays;

/**
 *
 * @author cstuser
 */
public class DiaryBook {

    private Diary[] diaries;
    private int diaryCounter;

    public DiaryBook() {
        //System.arraycopy(this.diaries, diaries, this.diaries, diaries, diaries); // DC
        diaries = new Diary[1];
    }

    public DiaryBook(DiaryBook anotherDiaryBook) {
//        System.arraycopy(anotherDiaryBook.diaries, 0, anotherDiaryBook.diaries, 0, diaries.length); //DC
        Arrays.copyOf(diaries, diaries.length);
        this.diaryCounter = anotherDiaryBook.diaryCounter;
    }

    public void addDiary(Diary d) {
        if (isFull()) {
            doubleCapacity();
        }

        diaries[diaryCounter] = new Diary(d);
        diaryCounter++;
    }

    private void doubleCapacity() {
        Diary[] newSet = new Diary[diaries.length * 2];

        for (int i = 0; i < diaries.length; i++) {
            newSet[i] = diaries[i];
        }
        diaries = newSet;
    }

    public boolean isFull() {
        return diaryCounter == diaries.length;
    }

    public int searcDiary(String title) {
        for (int i = 0; i < diaries.length; i++) {
            if (diaries[i].getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }

        return -1; // not found
    }

    public int countWeather(String weather, int startIdx, int endIdx) {
        int weatherCount = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            if (diaries[i].getWeatherCondition().equalsIgnoreCase(weather)) {
                weatherCount++;
            }
        }
        return weatherCount;
    }

    public Diary[] getDiaries() {
        return diaries;
    }

    public void setDiaries(Diary[] diaries) {
        this.diaries = diaries;
    }

    public int getDiaryCounter() {
        return diaryCounter;
    }

    public void setDiaryCounter(int diaryCounter) {
        this.diaryCounter = diaryCounter;
    }

    @Override
    public String toString() {
        String strOut = "";

        strOut += "Diaries\n";

        for (int i = 0; i < diaries.length; i++) {
            strOut += String.format("%s  %s  %s\n", diaries[i].getTitle(), diaries[i].getWeatherCondition(),
                    diaries[i].getContent());
        }

        return strOut;
    }

}
