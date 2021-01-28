package icu.sehnen.pojo;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "tb_category")
@Data

public class Category {
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private   Integer catId ;
  private  String  catName;
  private  Integer catPid;
   private  Integer catLevel;
   @Transient
   private List<Category> children;
}
