package com.goteatfproject.appgot.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.goteatfproject.appgot.vo.AttachedFile;
import com.goteatfproject.appgot.vo.Party;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PartyDao {

  int insert(Party party);

  List<Party> findAll();

  List<Party> findAll2(@Param("meal") String meal, @Param("food") String food);

  Party findByNo(int no);

  int update(Party party);

  int delete(int no);

  int insertFiles(Party party);

  AttachedFile findFileByNo(int fileNo);

  List<AttachedFile> findFilesByParty(int partyNo);

  int deleteFile(int fileNo);

  int deleteFiles(int partyNo);

  int deleteFilesByMemberParties(int memberNo);
}