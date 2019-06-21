package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public void save(Label label){
        label.setId(String.valueOf(idWorker.nextId()));
        labelDao.save(label);
    }

    public List<Label>  findAll(){
        return labelDao.findAll();
    }

    public Optional<Label> findById(String id){
        Optional<Label> byId = labelDao.findById(id);
        return byId;
    }

    public void delete(String id){
        labelDao.deleteById(id);
    }

    public void update(String id,Label label){
        labelDao.save(label);
    }

    public PageResult findAllPage(int page,int size,Label label){
        Pageable pageable = new PageRequest(page-1,size);

        Page<Label> all = labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate p1 = criteriaBuilder.equal(root.get("labelname").as(String.class), "");
                Predicate p2 = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                Predicate and1 = criteriaBuilder.or(p1, p2);

                Predicate p3 = criteriaBuilder.equal(root.get("state").as(String.class), "");
                Predicate p4 = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                Predicate and2 = criteriaBuilder.or(p1, p2);

                /*Predicate p5 = criteriaBuilder.equal(root.get("count").as(Long.class), "");
                Predicate p6 = criteriaBuilder.equal(root.get("count").as(Long.class), label.getCount());
                Predicate and3 = criteriaBuilder.or(p1, p2);*/

                Predicate p7 = criteriaBuilder.equal(root.get("recommend").as(String.class), "");
                Predicate p8 = criteriaBuilder.equal(root.get("recommend").as(String.class), label.getRecommend());
                Predicate and4 = criteriaBuilder.or(p1, p2);


                return criteriaBuilder.and(and1, and2,  and4);
            }
        }, pageable);
        return new  PageResult<Label>(all.getTotalElements(),all.getContent());
    }

    public PageResult findAllPage(Label label){
        List<Label> all = labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate p1 = criteriaBuilder.equal(root.get("labelname").as(String.class), "");
                Predicate p2 = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                Predicate and1 = criteriaBuilder.or(p1, p2);

                Predicate p3 = criteriaBuilder.equal(root.get("state").as(String.class), "");
                Predicate p4 = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                Predicate and2 = criteriaBuilder.or(p1, p2);

              /*  Predicate p5 = criteriaBuilder.equal(root.get("count").as(Long.class), "");
                Predicate p6 = criteriaBuilder.equal(root.get("count").as(Long.class), label.getCount());
                Predicate and3 = criteriaBuilder.or(p1, p2);*/

                Predicate p7 = criteriaBuilder.equal(root.get("recommend").as(String.class), "");
                Predicate p8 = criteriaBuilder.equal(root.get("recommend").as(String.class), label.getRecommend());
                Predicate and4 = criteriaBuilder.or(p1, p2);


                return criteriaBuilder.and(and1, and2, and4);
            }
        });
        return new  PageResult<Label>(new Long(all.size()),all);
    }
}
