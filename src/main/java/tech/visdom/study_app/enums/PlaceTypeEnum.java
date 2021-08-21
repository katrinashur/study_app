package tech.visdom.study_app.enums;


import lombok.Getter;

public enum PlaceTypeEnum {
    CHURCH("Церковь"),
    PARK("Парк"),
    MONUMENT("Памятник"),
    HISTORY_PLACE("Место исторического события");

    @Getter
    private String text;

    PlaceTypeEnum(String text) {
        this.text = text;
    }
}
