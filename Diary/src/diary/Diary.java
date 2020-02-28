package diary;

/**
 *
 * @author cstuser
 */
public class Diary {

    private String title;
    private String weatherCondition;
    private String content;

    public Diary(String title, String weatherCondition, String content) {
        this.title = title;
        this.weatherCondition = weatherCondition;
        this.content = content;

        if (!(weatherCondition.equals("sunny") || weatherCondition.equals("rainy")
                || weatherCondition.equals("cloudy") || weatherCondition.equals("snowy"))) {

            throw new IllegalArgumentException();

        }

    }

    public Diary(Diary anotherDiary) {
        this.title = anotherDiary.title;
        this.weatherCondition = anotherDiary.weatherCondition;
        this.content = anotherDiary.content;
    }

    public boolean equals(Diary anotherDiary) {
        return this.content.equals(anotherDiary.content)
                && this.title.equals(anotherDiary.title)
                && this.weatherCondition.equals(anotherDiary.weatherCondition);
    }

    @Override
    public String toString() {
        String strOut = "";

        strOut += String.format("%s  %s  %s", title, weatherCondition, content);

        return strOut;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
