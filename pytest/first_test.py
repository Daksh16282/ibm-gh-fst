import pytest,math

# pass
def test_sqrt():
    num = 25
    assert math.sqrt(num) == 5
# fail
def testsquare():
   num = 7
   assert num*num == 40
#  wil not run
def tesequality():
   assert 10 == 11