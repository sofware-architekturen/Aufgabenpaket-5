package de.hskl.itanalyst.supplier.controller.api;

import de.hskl.itanalyst.supplier.model.BookOrderDTO;
import de.hskl.itanalyst.supplier.model.BookOrderResponseDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/")
@Api(value = "Supplier API")
public class BookOrderAPI {
    @PostMapping("/orderBook")
    @ApiOperation(value = "Nachbestellung eines Buches.", response = BookOrderResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Buchbestellung erfolgreich.", response = BookOrderResponseDTO.class),
            @ApiResponse(code = 400, message = "Buchbestellung fehlgeschlagen.")
    })
    public ResponseEntity<BookOrderResponseDTO> orderBook(@ApiParam(value = "Book order details.", required = true) @RequestBody final BookOrderDTO bookOrderDTO) {
        try {
            final BookOrderResponseDTO bookOrderEntity = new BookOrderResponseDTO();
            bookOrderEntity.amount = bookOrderDTO.amount;
            bookOrderEntity.title = bookOrderDTO.title;
            bookOrderEntity.deliveryDate = LocalDate.now().plusDays((long)Math.random()*10+1);

            System.out.println("\n========== Buchbestellung eingetroffen ==========");
            System.out.println("Nachbestellung von Buch " + bookOrderDTO);
            System.out.println("=================================================\n");

            return ResponseEntity.ok(bookOrderEntity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
