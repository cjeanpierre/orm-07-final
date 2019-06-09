package com.puthisastra.first;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public Role findById(Long id) {
		return roleRepository.findById(id).get();
	}
}
