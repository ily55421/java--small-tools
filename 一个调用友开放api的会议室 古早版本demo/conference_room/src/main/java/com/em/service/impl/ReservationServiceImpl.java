package com.em.service.impl;

import com.em.dao.ReservationMapper;
import com.em.domain.PagingVO;
import com.em.domain.Reservation;
import com.em.domain.ReservationVo;
import com.em.domain.Room;
import com.em.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admiral on 2018/1/19.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    public List<Room> findRoomsByTime(String date, String begintime, String endtime){
        return reservationMapper.findRoomsByTime(date, begintime, endtime);
    }

    @Override
    public Integer reservationCount() {
        return reservationMapper.reservationCount();
    }

    @Override
    public List<ReservationVo> findByPaging(Integer toPageNo) {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<ReservationVo> list = reservationMapper.findByPaging(pagingVO);
        return list;
    }

    @Override
    public List<Reservation> findByName(String name) {
        return reservationMapper.findByName(name);
    }

    public Reservation findById(Integer id) {
        return reservationMapper.findById(id);
    }

    @Override
    public Integer reservationPassCount() {
        return reservationMapper.reservationPassCount();
    }

    @Override
    public List<ReservationVo> findRecord(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<ReservationVo> list = reservationMapper.findRecord(pagingVO);
        return list;
    }

    @Override
    public void reviewReservation(Integer id) throws Exception {
        reservationMapper.reviewReservation(id);
    }

    @Override
    public Integer reserveCount() throws Exception {
        return reservationMapper.reserveCount();
    }

    @Override
    public List<ReservationVo> findAllByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<ReservationVo> list = reservationMapper.findAllByPaging(pagingVO);
        return list;
    }

    @Override
    public void addReservation(Reservation reservation) throws Exception {
        reservationMapper.addReservation(reservation);
    }

    @Override
    public List<ReservationVo> queryByUser(String name) throws Exception {
        return reservationMapper.queryByUser(name);
    }

    @Override
    public List<Reservation> findByUser(String user) throws Exception {
        return reservationMapper.findByUser(user);
    }

    @Override
    public void cancelApplication(Integer id) throws Exception {
        reservationMapper.cancelApplication(id);
    }
}
