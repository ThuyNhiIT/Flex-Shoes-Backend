package com.flexshose.flexshoesbackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flexshose.flexshoesbackend.entity.Color;
import com.flexshose.flexshoesbackend.repository.ColorRepository;
import com.flexshose.flexshoesbackend.service.ColorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
	private final ColorRepository colorRepository;

	@Override
	public List<Color> getAllColors() {
		// TODO Auto-generated method stub
		return colorRepository.findAll();
	}
	

}
