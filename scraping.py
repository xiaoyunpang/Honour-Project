from urllib2 import urlopen
import urllib2
from bs4 import BeautifulSoup
import lxml
import string
import csv
import sys
from socket import error as SocketError
import errno

def parse_contents(html):
	return filter(lambda x: not(x.strip() == ''), html.encode('ascii','ignore').replace('\t', '').splitlines())

writer = csv.writer(open('data/award-datails.csv', 'w'))
writer.writerow(['Research Title', 'Competition Year', 'Fiscal Year', 'Project Lead Name', 'Institution',
				 'Department', 'Province', 'Award Amount', 'Installment', 'Program', 'Selection Committee',
				 'Research Subject', 'Area of Application', 'Co-Researchers', 'Partners', 'Award Summary'])

def scrape_html(link, num):
	html = urlopen(link)
	bsObj = BeautifulSoup(html, 'lxml')
	form = bsObj.find("div", {"id": "main-container-1col"})
	raw_data = parse_contents(form.text)
	while raw_data[1].strip() != 'Research Details':
		raw_data[0:2] = [''.join(raw_data[0:2])]
	if raw_data[7] == 'Institution:':
		raw_data.insert(7, 'None')
	if raw_data[11] == 'Province:':
		raw_data.insert(11, 'None')
	if raw_data[13] == 'Award Amount:':
		raw_data.insert(13, 'None')
	name = raw_data.pop(0)
	final_data = map(lambda x: x.strip(), [name] + raw_data[::2][1:])
	writer.writerow(final_data)

for num in range(int(sys.argv[1]), 592608):
	link = "http://www.nserc-crsng.gc.ca/ase-oro/Details-Detailles_eng.asp?id=" + str(num)
	try:
		scrape_html(link, num)
	except urllib2.HTTPError, error:
		print "Data lost: " + str(num)
	except SocketError:
		print "Socket Error: " + str(num)
		scrape_html(link,num)
	except urllib2.URLError:
		print "Timeout Error: " + str(num)
		scrape_html(link, num)
