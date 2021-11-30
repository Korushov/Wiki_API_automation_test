package Entities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MainWarning {

    @SerializedName("*")
    private String text;
}
