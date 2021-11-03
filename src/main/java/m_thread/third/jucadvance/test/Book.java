package m_thread.third.jucadvance.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author l
 * @date 2021/11/3 11:30
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
    private Integer id;
    private String bookName;
    private double price;
    private String author;
}
