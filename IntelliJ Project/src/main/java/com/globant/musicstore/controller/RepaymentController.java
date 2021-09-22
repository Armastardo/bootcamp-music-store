package com.globant.musicstore.controller;



import com.globant.musicstore.dto.RepaymentDTO;
import com.globant.musicstore.dto.ResponseDTO;
import com.globant.musicstore.service.RepaymentService;
import com.globant.musicstore.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.globant.musicstore.utils.Constants.ID_FOUNDED_SUCCESSFULLY;
import static com.globant.musicstore.utils.Constants.ITEM_ADDED_SUCCESSFULLY;
import static com.globant.musicstore.utils.Constants.ITEM_UPDATED_SUCCESSFULLY;


@RestController
@RequestMapping
public class RepaymentController {

    @Autowired
    RepaymentService repaymentService;

    @GetMapping(path = "/{intAlbumId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<RepaymentDTO>> getAlbumId(@PathVariable Long albumId) {

        ResponseDTO repaymentResponseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ID_FOUNDED_SUCCESSFULLY, repaymentService.getAlbumId(albumId));
        return new ResponseEntity<>(repaymentResponseDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id_repayment}")
    public ResponseEntity<ResponseDTO<RepaymentDTO>> deleteRepayment(@PathVariable Long repaymentId) {
        ResponseDTO repaymentResponseDTO  = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ID_FOUNDED_SUCCESSFULLY , repaymentService.deleteRepayment(repaymentId));
        return new ResponseEntity<>(repaymentResponseDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<RepaymentDTO>> updateRepayment(@PathVariable Long id, @RequestBody RepaymentDTO repaymentDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_UPDATED_SUCCESSFULLY, repaymentService.updateRepayment(id, repaymentDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @PostMapping(path = "/add/{id_repayment}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<RepaymentDTO>> addRepayment(@PathVariable Long id, @RequestBody RepaymentDTO repaymentDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_ADDED_SUCCESSFULLY, repaymentService.addRepayment(id, repaymentDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
