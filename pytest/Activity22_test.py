import pytest

@pytest.mark.inc
def test_sum():
    num1 = 5
    num2 = 10
    assert num1+num2 == 15

@pytest.mark.dec
def test_diff():
    num1 = 5
    num2 = 10
    assert num1-num2 == -5

@pytest.mark.inc
def test_mul():
    num1 = 5
    num2 = 10
    assert num1*num2 == 50

@pytest.mark.dec
def test_div():
    num1 = 5
    num2 = 10
    assert num2/num1 == 2

