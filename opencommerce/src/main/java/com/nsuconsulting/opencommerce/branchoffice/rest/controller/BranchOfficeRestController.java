package com.nsuconsulting.opencommerce.branchoffice.rest.controller;

import com.nsuconsulting.opencommerce.branchoffice.exception.BranchOfficeNotFoundException;
import com.nsuconsulting.opencommerce.branchoffice.model.BranchOffice;
import com.nsuconsulting.opencommerce.branchoffice.rest.dto.*;
import com.nsuconsulting.opencommerce.branchoffice.service.BranchOfficeService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/branch-office")
public class BranchOfficeRestController {

	@Autowired
	private BranchOfficeService branchOfficeService;
	@Autowired
	private MapperFacade orikaMapper;

	@GetMapping
	public List<BranchOfficeListDTO> readBranchOfficeList() {
		return orikaMapper.mapAsList(branchOfficeService.findALlBranchOffices(), BranchOfficeListDTO.class);
	}

	@GetMapping("/{id}")
	public BranchOfficeDTO getBranchOffice(@NotNull @PathVariable("id") Long id) {
		return orikaMapper.map(branchOfficeService.findBranchOfficeById(id).orElseThrow(() -> new BranchOfficeNotFoundException(id.toString())), BranchOfficeDTO.class);
	}

	@PostMapping
	public BranchOfficeDTO createBranchOffice(@NotNull @RequestBody @Valid CreateBranchOfficeRequest request) {
		return orikaMapper.map(branchOfficeService.createBranchOffice(orikaMapper.map(request, BranchOffice.class)), BranchOfficeDTO.class);
	}

	@PutMapping
	public BranchOfficeDTO updateBranchOffice(@NotNull @RequestBody @Valid UpdateBranchOfficeRequest request) {
		return orikaMapper.map(branchOfficeService.updateBranchOffice(orikaMapper.map(request, BranchOffice.class)), BranchOfficeDTO.class);
	}

	@DeleteMapping("/{id}")
	public void deleteOffice(@PathVariable("id") @NotNull Long id) {
		branchOfficeService.deleteBranchOffice(id);
	}


}
