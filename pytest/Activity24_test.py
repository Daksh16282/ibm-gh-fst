import pytest

@pytest.mark.parametrize("earned, spent, expected",[(30,10,20),(20,2,18)])
def test_transaction(getAmount,earned, spent, expected):
    walletAmount = getAmount
    walletAmount+=earned
    walletAmount-=spent
    assert walletAmount == expected