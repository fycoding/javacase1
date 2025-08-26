// 提交
document.querySelector('.submit').addEventListener('click', function () {
    submit();
});

document.querySelector('.pagination').addEventListener('click', function (e) {
    setPage(e.target.innerText);
    submit();
});

document.querySelector('.nextPage').addEventListener('click', function (e) {
    e.stopPropagation();
    let curPage = document.querySelector('.page-item.active a').innerText;
    setPage(+curPage + 1);
    submit();
})

document.querySelector('.prevPage').addEventListener('click', function (e) {
    e.stopPropagation();
    let curPage = document.querySelector('.page-item.active a').innerText;
    setPage(+curPage - 1);
    submit();
})

function setPage(page) {
    let lis = document.querySelectorAll('.page-item');
    // 最大
    let maxPage = lis.length;
    if(page > maxPage) {
        page = maxPage; 
    }
    // 最小
    if(page < 1) {
        page = 1; 
    }
    lis.forEach((currentValue) => {
        currentValue.classList.remove('active');
        if (currentValue.querySelector('a').innerText == page) {
            currentValue.classList.add('active');
        }
    })
}




function submit() {
    // 分页
    let curPage = +document.querySelector('.pagination li.active a').innerText;
    // 表单数据
    let searchForm = document.querySelector('.search');
    let formdata = new FormData(searchForm);
    let url = `?page=${curPage}&name=${formdata.get('name')}&email=${formdata.get('email')}`;
    window.location.href = url;
}