package ra.students.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.students.repository.IStudentRepository;

@Component
public class PhoneValidator implements ConstraintValidator<PhoneUnique,String> {
  @Autowired
  private IStudentRepository studentRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return !studentRepository.existsByPhone(value);
    }
}
