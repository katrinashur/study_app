package tech.visdom.study_app.enums;

import lombok.Getter;

public enum RouteCategoryEnum {
    BY_FOOT("Пеший"),
    BY_CAR("На машине"),
    BY_BUS("На автобусе");

    @Getter
    private String text;

    RouteCategoryEnum(String text) {
        this.text = text;
    }
}
