/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.service.Impl;


import com.ntd.repository.StatsRepository;
import com.ntd.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class StatsServiceImpl implements StatsService{
    
    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> stats(String kw,Date fromDate, Date toDate) {
        return this.statsRepository.stats(kw,fromDate, toDate);
    }

    @Override
    public List<Object[]> revenueStats(int y) {
        return this.statsRepository.revenueStats(y);
    }
    
}
