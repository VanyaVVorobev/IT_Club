package ru.vanyavvorobev.ITClub.dto.request;

import java.util.List;

public class PositionRequestDto {

    private List<String> position;

    public PositionRequestDto() {}
    public PositionRequestDto(List<String> position) {
        this.position = position;
    }

    public List<String> getPosition() {
        return position;
    }

    public void setPosition(List<String> position) {
        this.position = position;
    }
}
