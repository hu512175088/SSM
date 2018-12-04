package com.ssm.service.impl;

import com.ssm.dao.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper mapper;

	@Override
	public User searchUserCodeIsExists(String userCode) {
		// TODO Auto-generated method stub
		return mapper.searchUserCodeIsExists(userCode);
	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return mapper.add(user);
	}

	@Override
	public List<User> searchUserListByUserNameAndGenderAndDateTime(User user) {
		// TODO Auto-generated method stub
		return mapper.searchUserListByUserNameAndGenderAndDateTime(user);
	}

	@Override
	public int count(User user) {
		// TODO Auto-generated method stub
		return mapper.count(user);
	}

//	@Override
//	public int pageCount(User user) {
//		// TODO Auto-generated method stub
//		// 获取总记录数
//		int count = mapper.count(user);
//		// 求总页数:总记录数/每页显示的条数
//		int pageCount = (count % user.getPageSize() == 0)?(count / user.getPageSize()):((count / user.getPageSize()) + 1);
//		return pageCount;
//	}
	
}
