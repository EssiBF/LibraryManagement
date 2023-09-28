package ir.mapsa.librarymanagement.base;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public abstract class BaseController<QDto extends BaseDto, SDto extends BaseDto, ID extends Number>
        implements IBaseController<QDto, SDto, ID> {

    public final IBaseService<QDto, SDto, ID> baseService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SDto> findById(@PathVariable ID id) throws BaseException {
        SDto sDto = baseService.findById(id);
        return new ResponseEntity<>(sDto, HttpStatus.OK);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<SDto>> findAll() {
        return new ResponseEntity<>(baseService.findAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<SDto> create(@RequestBody QDto qDto) {
        return new ResponseEntity<>(baseService.create(qDto), HttpStatus.CREATED);
    }

    @Override
    @PatchMapping
    public ResponseEntity<SDto> update(@RequestBody QDto qDto) throws BaseException {
        return new ResponseEntity<>(baseService.update(qDto), HttpStatus.ACCEPTED);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSafelyById(@PathVariable ID id) throws BaseException {
        baseService.deleteSafelyById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
