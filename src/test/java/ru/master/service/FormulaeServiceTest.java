package ru.master.service;

import org.junit.jupiter.api.*;
import ru.master.utils.Utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class FormulaeServiceTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }


  @Test
  public void testUtils() {
    /*Полис ID: 8554920893 part1: -4998569325.58673491
    Полис ID: 8554920893 part2: 19.80000000
    Полис ID: 8554920893 result: -4998569305.78673491*/
    //BigDecimal part1 = BigDecimal.valueOf(-4998569325.58673491);
    //BigDecimal part1 = null;
    //BigDecimal part1 = BigDecimal.valueOf(0.0);
    BigDecimal part1 = BigDecimal.valueOf(4998569325.58673491);
    //boolean b = Utils.isNonNullNonZeroBigDecimal(part1);
    boolean b = Utils.isNonNullButZeroBigDecimal(part1);
    System.out.println(b);
    Assertions.assertTrue(b);
  }

  @Test
  void getSome() {
    LocalDate _calc_date1 = LocalDate.of(2021, 3, 4); //2021-03-04;
    LocalDate _calc_date2 = LocalDate.of(2021, 3, 4); //2021-03-04;



    double days_between = Math.abs(ChronoUnit
        .DAYS
        .between(_calc_date1, _calc_date2));

    System.out.println(days_between);
  }


  @Test
  void getMwrYield() {
    FormulaeService fs = new FormulaeService();

//    BigDecimal compared_result = BigDecimal.valueOf(499856934537605579L, 8);
    BigDecimal compared_result = BigDecimal.valueOf(499856932557605579L, 8);

    Long        _urgency = 5L;
    BigDecimal  _z_factor = BigDecimal.valueOf(0.00533956);
    LocalDate   _calc_date = LocalDate.of(2021, 3, 4); //2021-03-04;
    LocalDate   _insurance_start_date = LocalDate.of(2020, 4, 24); // 2020-04-24
    BigDecimal  _guarantee_rate = BigDecimal.valueOf(100.00000000);
    BigDecimal  _insurance_prem_rub = BigDecimal.valueOf(200000.0000);
    BigDecimal  _insurance_prem_nonrub = BigDecimal.valueOf(0.0000);
    BigDecimal  _profitability = BigDecimal.valueOf(21493.8481);

    BigDecimal result = fs.getMwrYield("prot_uuid",
        _urgency,
        _z_factor,
        _calc_date,
        _insurance_start_date,
        _guarantee_rate,
        _insurance_prem_rub,
        _insurance_prem_nonrub,
        _profitability,
        8554920893L);

    System.out.println("result1: " + result);
    System.out.println("result2: " + compared_result);

    Assertions.assertTrue((result.compareTo(compared_result)) == 0);
  }
}