import pytest

@pytest.fixture
def getList():
    list = [i for i in range(1,11)]
    return list

@pytest.fixture
def getAmount():
    amount=0
    return amount