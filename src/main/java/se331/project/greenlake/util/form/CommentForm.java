package se331.project.greenlake.util.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentForm {
    String content;
    Long comment_by;
    Long comment_to;
}
