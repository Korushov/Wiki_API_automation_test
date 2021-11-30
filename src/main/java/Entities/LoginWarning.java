package Entities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoginWarning {

    @SerializedName("*")
    private String text;
}
