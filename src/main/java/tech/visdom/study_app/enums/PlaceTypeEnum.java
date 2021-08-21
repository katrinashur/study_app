package tech.visdom.study_app.enums;


import lombok.Getter;

public enum PlaceTypeEnum {
    CHURCH("Церковь");

    @Getter
    private String text;

    PlaceTypeEnum(String text) {
        this.text = text;
    }
}
