package com.example.codingexerciseweektwo.Controller.Class;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Member object",description = "Member object creating")


public class Member {
    @ApiModelProperty(value = "Unique field for member class.")
    private Integer memberId;
    @ApiModelProperty(value = "Member name.")
    private String  memberName;
    @ApiModelProperty(value = "Member birth year.")
    private Integer  memberBirthYear;
    @ApiModelProperty(value = "Member mail address.")
    private String  memberMail;
    @ApiModelProperty(value = "Member watchlist name. Default by null.")
    private String watchListName;
    @ApiModelProperty(value = "Member watchlist. Default by null.")
    private Watchlist watchlist;

}
