export interface Page {
    currentPage: number;
    totalPages: number;
    nextPage: any;
    previousPage: any;

}

const Paginate = (page: Page) => {

    return (
        <div className="container pagination-container">
            <ul className="pagination">
                <button onClick={page.previousPage} className="page-number">
                    Prev
                </button>
                <button onClick={page.nextPage} disabled={page.currentPage + 1 === page.totalPages} className="page-number">
                    Next
                </button>
            </ul>
        </div>
    );

};

export default Paginate;