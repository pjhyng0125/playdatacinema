package com.playdata.model.vo;


/*
 * �������: ȸ���� ������ ���� ����
 */
public class Member {                        // �ʿ���� - ���� ��й�ȣ ã�� ��� ���� �ش� ��� ����?
      
   private String id;         // ���� id
   private String pass;      // ���� ��й�ȣ
   private String gender;      // ���� ����
   private String name;      // ���� �̸�
   private String birth;         // ���� �������
   private String phone;      // ���� ��ȭ��ȣ   
   private String addr;      // ���� �ּ� -> �ʿ��Ѱ�?
   private String email;      // ���� ����
   private int point;         // ���� ���� ����Ʈ
   private int cash;         // ���� �ܾ�
   private int mem_grade;      // ���� ���   
   private String hint;      // ���� ���ã�� ����
   private String answer;      // ���� ���ã�� ��
   
   public Member() {
      
   }

   public Member(String id, String pass, String gender, String name, String birth, String phone, String addr,
         String email, int point, int cash, int mem_grade, String hint, String answer) {
      super();
      this.id = id;
      this.pass = pass;
      this.gender = gender;
      this.name = name;
      this.birth = birth;
      this.phone = phone;
      this.addr = addr;
      this.email = email;
      this.point = point;
      this.cash = cash;
      this.mem_grade = mem_grade;
      this.hint = hint;
      this.answer = answer;
   }



   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPass() {
      return pass;
   }

   public void setPass(String pass) {
      this.pass = pass;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getBirth() {
      return birth;
   }

   public void setBirth(String birth) {
      this.birth = birth;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getAddr() {
      return addr;
   }

   public void setAddr(String addr) {
      this.addr = addr;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public int getPoint() {
      return point;
   }

   public void setPoint(int point) {
      this.point = point;
   }

   public int getCash() {
      return cash;
   }

   public void setCash(int cash) {
      this.cash = cash;
   }

   public int getMem_grade() {
      return mem_grade;
   }

   public void setMem_grade(int mem_grade) {
      this.mem_grade = mem_grade;
   }

   public String getHint() {
      return hint;
   }

   public void setHint(String hint) {
      this.hint = hint;
   }

   public String getAnswer() {
      return answer;
   }

   public void setAnswer(String answer) {
      this.answer = answer;
   }
   
   
}